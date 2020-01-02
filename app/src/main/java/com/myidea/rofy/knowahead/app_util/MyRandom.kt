package com.myidea.rofy.knowahead.app_util

class MyRandom {

    object Static {

        private val inventory: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"

        public fun makeRandom(n: Int = 13): String {
            var toReturn = ""
            var i = 1
            while (i <= n) {
                toReturn += inventory[(inventory.length * Math.random()).toInt()].toString()
                i++
            }
            return toReturn + "ApM"
        }

    }

}