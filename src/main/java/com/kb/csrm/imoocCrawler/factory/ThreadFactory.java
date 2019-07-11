/**
 * 线程池
 *
 * @author yi.wang11@hand-china.com
 * @version 1.0
 * @date 2019/07/08
 */

package com.kb.csrm.imoocCrawler.factory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactory {

	public static ThreadPoolExecutor getThreadPool() {
		return new ThreadPoolExecutor(5, 10, 500, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
	}
}
