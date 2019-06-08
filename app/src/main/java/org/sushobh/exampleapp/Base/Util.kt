package org.sushobh.exampleapp.Base

import java.text.SimpleDateFormat
import java.util.*

class Util {


   companion object {
       fun convertDateStringToFormat(dateString : String,currentFormat : String, expectedFormat : String) : String{
           val sdf1 = SimpleDateFormat(currentFormat, Locale.ENGLISH)
           var date = sdf1.parse(dateString)
           val sdf2 = SimpleDateFormat(expectedFormat,Locale.ENGLISH)
           return sdf2.format(date)
       }
   }
}