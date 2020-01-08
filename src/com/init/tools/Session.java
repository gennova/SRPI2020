/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import com.ypii.suster.Suster;

/**
 *
 * @author amnesia
 */
public class Session {

    private static String NoInduk;
    private static Suster suster;

    public static String getNoInduk() {
        return NoInduk;
    }

    public static void setNoInduk(String NoInduk) {
        Session.NoInduk = NoInduk;
    }

    public static Suster getSuster() {
        return suster;
    }

    public static void setSuster(Suster suster) {
        Session.suster = suster;
    }

}
