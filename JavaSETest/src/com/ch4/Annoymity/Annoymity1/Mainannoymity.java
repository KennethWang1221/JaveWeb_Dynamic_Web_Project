package com.ch4.Annoymity.Annoymity1;

public class Mainannoymity extends SoftWare implements Phone,ReleaseTime {
    public void time() {

    }

    @Override
    public void band() {

    }

    @Override
    public void country() {

    }

    @Override
    public void money() {

    }



    public void getOs(SoftWare sw) {
        sw.os();
    }

    public void getBand(Phone ph) {
        ph.band();
        ph.country();
        ph.money();
    }

    public void getRelease(ReleaseTime re) {
        re.time();
    }



    public static void main(String[] args){
        Mainannoymity ma=new Mainannoymity();

        ma.getOs(new SoftWare() {
            public void os() {
                System.out.println("这是定义在匿名类中的操作系统方法");
            }
        });

        ma.getBand(new Phone() {
            public void band() {
                System.out.println("iphone 6plus 64GB");
            }

            public void country() {
                System.out.println("美国");
            }

            public void money() {
                System.out.println("4999");
            }
        });

        ma.getRelease(new ReleaseTime() {
            @Override
            public void time() {
                System.out.println("2015年 9月 与 6a同步全球发售");
            }
        });
    }
}
