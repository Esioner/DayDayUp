package com.esioner.myapplication.neihan;


public class MessageEvent {
    private int taskName;
    private boolean status;

    public MessageEvent() {
    }

    public MessageEvent(int taskName, boolean status) {
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskName() {
        return taskName;
    }

    public void setTaskName(int taskName) {
        this.taskName = taskName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
