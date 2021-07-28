package ru.pfr.modules.xls_parser_fin_monitor

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.util.*

fun main(args: Array<String>) {
    val p = XLSParser()
        .parsingFileToOrgList("F:\\Programms\\different\\java\\modulForSpring\\in\\reg.xls")

    for (o in p){
           println(o)
       }
}
