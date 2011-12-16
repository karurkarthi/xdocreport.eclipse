/*******************************************************************************
 * Copyright (C) 2011 Angelo Zerr <angelo.zerr@gmail.com>, Pascal Leclercq <pascal.leclercq@gmail.com>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Angelo ZERR - initial API and implementation
 *     Pascal Leclercq - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.pagination;

/**
 * Handler used to do something before/after page loading process. You can for
 * instance display a "Loading" message when pagination start and close it when
 * data are loaded.
 * 
 * @param <T>
 *            the pagination controller.
 */
public interface PageLoaderHandler<T extends PaginationController> {

	/** Default Handler **/
	public static final PageLoaderHandler<?> DEFAULT_HANDLER = new PageLoaderHandler<PaginationController>() {

		public void onBeforePageLoad(PaginationController controller) {

		}

		public boolean onAfterPageLoad(PaginationController controller,
				Throwable e) {
			if (e != null) {
				// Error while page loading was processed, display the stack
				// trace.
				e.printStackTrace();
			}
			return true;
		}

	};

	/**
	 * This method is called before page loading process.
	 * 
	 * @param controller
	 *            the pagination controller.
	 */
	void onBeforePageLoad(T controller);

	/**
	 * This method is called after page loading process. If there is an error
	 * the given exception is filled with the exception.
	 * 
	 * @param controller
	 * @param e
	 * @return true if exception (when there is an error) must be thrown and
	 *         false otherwise.
	 */
	boolean onAfterPageLoad(T controller, Throwable e);
}