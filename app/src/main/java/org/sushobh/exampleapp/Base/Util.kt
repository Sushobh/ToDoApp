package org.sushobh.exampleapp.Base

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class Util {


   companion object {
       fun convertDateStringToFormat(dateString : String,currentFormat : String, expectedFormat : String) : String{
           val sdf1 = SimpleDateFormat(currentFormat, Locale.ENGLISH)
           var date = sdf1.parse(dateString)
           val sdf2 = SimpleDateFormat(expectedFormat,Locale.ENGLISH)
           return sdf2.format(date)
       }

       fun getCurrentTimeStamp() : String {

          return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()).toString()
       }
   }
}