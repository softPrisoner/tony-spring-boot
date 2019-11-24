package com.tony.common.ks.other2;

public class MySignal {
    private boolean hasDataToProcess = false;

    public boolean getHasDataToProcess() {
        return hasDataToProcess;
    }

    public void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }

    public static void main(String[] args) {
        final MySignal s = new MySignal();
        Thread t1 = new Thread(() -> {
            try {
                s.setHasDataToProcess(true);
            } catch (Exception e) {
            }

        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {

            private boolean hasDataToProcess2;

            @Override
            public void run() {
                try {
                    t1.join();
                    hasDataToProcess2 = s.getHasDataToProcess();
                    System.out.println(hasDataToProcess2);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                } catch (Exception e) {
                } finally {
                    System.out.println("B�ͷ�����");
                }

            }
        });
        t2.start();
    }
}
