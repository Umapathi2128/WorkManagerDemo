package com.uma.workmanagerdemo.ui.setalarm

/**
 * Created by Umapathi on 2019-09-18.
 * Copyright Indyzen Inc, @2019
 */
interface AlarmView {

    /**
     *  This method for start work manager with one time request....
     */
    fun oneTimeRequest()

    /**
     *  This method for Queuing work manager....
     */
    fun queuingWork()

    /**
     *  This method for Cancel work by using tag name....
     */
    fun cancelWorkByTag()

    /**
     *  This method for Queuing work with list manager....
     */
    fun queuingWorkWithList()

    /**
     * THIS METHOD FOR cancel periodical request the work manger...
     */
    fun cancelPeriodicalRequest()

    /**
     * THIS METHOD FOR priodic request to the work manger...
     */
    fun periodicalRequest()

    /**
     * THIS METHOD FOR Working with chain of request...
     */
    fun worKWithChain()

}