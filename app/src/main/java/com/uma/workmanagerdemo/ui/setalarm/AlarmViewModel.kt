package com.uma.workmanagerdemo.ui.setalarm

/**
 * Created by Umapathi on 2019-09-18.
 * Copyright Indyzen Inc, @2019
 */
class AlarmViewModel(var alarmView: AlarmView) {

    /**
     *  This method for start work manager....
     */
    fun oneTimeRequest() {
        alarmView.oneTimeRequest()
    }

    /**
     *  This method for start Queuing work manager....
     */
    fun queuingWork() {
        alarmView.queuingWork()
    }

    /**
     *  This method for Cancel work by using tag name........
     */
    fun cancelWorkBytag() {
        alarmView.cancelWorkByTag()
    }

    /**
     *  This method for start Queuing work with list manager....
     */
    fun queuingWorkWithList() {
        alarmView.queuingWorkWithList()
    }

    /**
     * THIS METHOD FOR cancel the work manger...
     */
    fun cancelPeriodicalRequest() {
        alarmView.cancelPeriodicalRequest()
    }

    /**
     * THIS METHOD FOR periodic request the work manger...
     */
    fun periodicalRequest() {
        alarmView.periodicalRequest()
    }

    /**
     * THIS METHOD FOR Work with chain of requests...
     */
    fun workWithChain() {
        alarmView.worKWithChain()
    }
}