package ru.pfr.modules.xls_parser_fin_monitor

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.util.*

fun main(args: Array<String>) {
    val p = XLSParser()
        .parsingFileToOrgList("D:\\!!!DOCUMENTS\\ФИН. САНКЦИИ ПО СВЕРКЕ (УВЕДОМЛЕНИЯ)\\Таблица рег-новая1.xls")

    for (o in p){
           println(o)
       }
}
