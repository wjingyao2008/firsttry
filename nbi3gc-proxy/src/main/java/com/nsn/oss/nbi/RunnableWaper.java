package com.nsn.oss.nbi;


import com.nsn.oss.nbi.common.Logger;

/**
 * Created by y28yang on 1/25/2016.
 */
public class RunnableWaper implements Runnable {


    private final static Logger LOGGER = Logger.getLogger(RunnableWaper.class);
    private Runnable job;

    public RunnableWaper(Runnable job) {
        this.job = job;
    }


    @Override
    public void run() {
        try {
            job.run();
        }catch (Throwable ex){
            LOGGER.error(ex);
        }
    }
}
