//package com.tony.rocketmq.namesrv.bloomfilter;
//
//import com.google.common.hash.Hashing;
//
//import java.nio.charset.Charset;
//
///**
// * @author tony
// * @describe BloomFilter
// * @date 2019-08-19
// */
//public class BloomFilter{
//    public static final Charset UTF_8 = Charset.forName("UTF-8");
//    private int f = 10;
//    private int n = 128;
//    //hash function calculate times
//    private int k;
//    //    bit count
//    private int m;
//
//    public static BloomFilter createByFn(int f, int n) {
//        return new BloomFilter(f, n);
//    }
//
//    public BloomFilter(int f, int n) {
//        if (f < 1 || f >= 100) {
//            throw new IllegalArgumentException("f muster be greater or equal than 1 and less than 100");
//        }
//        if (n < 1) {
//            throw new IllegalArgumentException("n must be greater than 0");
//        }
//        this.f=f;
//        this.n=n;
//        double errorRate=f/100.0;
//        this.k= (int) Math.ceil(logMN(0.5,errorRate));
//        if (this.k<1){
//            throw new IllegalArgumentException("Hash function num is less than 1" +
//                    ",maybe you should change the value of error rate or bit num ");
//        }
//    }
//
//    private double logMN(double v, double errorRate) {
//    }
//}
