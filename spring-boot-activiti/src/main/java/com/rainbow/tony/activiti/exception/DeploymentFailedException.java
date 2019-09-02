package com.rainbow.tony.activiti.exception;

/**
 * @author tony
 * @describe DeploymentFailedException
 * @date 2019-08-31
 */
public class DeploymentFailedException extends Exception {
    public DeploymentFailedException(String message) {
        super(message);
    }

    public DeploymentFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeploymentFailedException(Throwable cause) {
        super(cause);
    }

    protected DeploymentFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
