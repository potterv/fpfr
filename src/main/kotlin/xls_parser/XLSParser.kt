package ru.pfr.modules.xls_parser_fin_monitor

import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.FileInputStream
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.ss.util.NumberToTextConverter
import java.io.File
import java.io.IOException

/**
 * Парсер, парсит файлы xls
 * */
class XLSParser {

    private var numberOfHeaderIterator = 0  // Для пропуска шапки
    private var numberOfHeader = 1 // Кол-во строк шапки таблицы

    /**
     * Создание нового обьекта
     * @param fileName полный путь к файл который необходим парсить
     * */
    constructor()

    /**
     *Файл xls в лист организаций
     * @param fileName
     * @return orgList:MutableList<Organization>
     */
    fun parsingFileToOrgList(fileName:String):MutableList<Organization>{
        //---- Проверка существует ли файл и его расширение ----
        val f = File(fileName)
        if (f.isFile.and(fileName.endsWith(".xls")))
        {}
        else throw IOException("""Путь к файлу указан неверно или файл\расширение не верны 
                |Файл: $f """.trimMargin())

        //---- Обьявление переменных ----

        var isExist = false // Есть ли организация в списке
        var org = Organization()

        val list = mutableListOf<Organization>()

        val workBook = HSSFWorkbook(FileInputStream(fileName)) //Открываем файл и его рабочую область workBook
        val sheet = workBook.getSheetAt(0)  //Работаем с первой станицой\вкладкой эксель,
        val lastRow = sheet.lastRowNum // Для обработки последней организации в списке
        val rows = sheet.rowIterator()

        //---- Пропуск шапки таблицы ----
        if (rows.hasNext())
            while (numberOfHeaderIterator < numberOfHeader) {
                if (rows.hasNext())
                    rows.next()
                numberOfHeaderIterator++
            }

        //---- Начало перебора ячеек ----
        while (rows.hasNext()) {
            val row = rows.next() as HSSFRow
            for (cell in row)
            {
                //Запись

                when (cell.columnIndex){
                    // ---- Проверка совпадения рег номера в уже добавленых организациях ----
                    1 -> {
                        if (checkCellType(cell) != org.regNumber) { //Если текущий номер не равен номеру организации который только что заполняли
                            for (organization in list) { //Проверить есть ли у нас такая организация
                                if (checkCellType(cell) == organization.regNumber) { //Если есть дополняем её
                                    org = organization
                                    isExist = true
                                }
                            }
                            if (org.regNumber.isNotEmpty() && org.regNumber!= checkCellType(cell)){ //Избавился от пустого попадания
                                if (!isExist) { //Если такой организации нет добавить
                                    list.add(org)
                                    org = Organization()
                                }
                                else // Если организацие есть, продолжить с новой
                                {
                                    isExist = false
                                    org = Organization()

                                }
                            }
                        }
                        org.regNumber = checkCellType(cell)

                    }
                    2 -> org.orgName = checkCellType(cell)

                    // Заполнение временных массивов
                    3,4,5,6   -> org.addToTempArrays(checkCellType(cell), 1)
                    7,8,9,10  -> org.addToTempArrays(checkCellType(cell), 2)
                    11,12,13,14 -> org.addToTempArrays(checkCellType(cell), 3)
                    else -> continue

                }
            }
            org.addToArrays()
            if (row.rowNum == lastRow){
                list.add(org)
            }
            org.newTempArrays()
        }

        return list
    }

    /**
     * Проверка типов ячеек
     * @return cell:String;
     *         date:String;
     *         null если другой тип;
     * @exception regNumber отсутствует
     * */
    private fun checkCellType(cell:Cell):String{
        return when (cell.cellType) {
            CellType.STRING -> cell.stringCellValue
            CellType.NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    cell.toString()
                } else {
                    NumberToTextConverter.toText(cell.numericCellValue)
                }
            }
            CellType.BOOLEAN -> cell.booleanCellValue.toString()
            CellType.BLANK -> {
                if (cell.columnIndex.equals(1)){
                    throw IOException("No reg name!!! In index ->${cell.columnIndex}, in row ->${cell.rowIndex},  is an error type")
                } else "null"
            }
            CellType._NONE -> "null_NONE"
            CellType.FORMULA -> "null_FORMULA"
            else -> throw IOException("In index ->${cell.columnIndex}, in row ->${cell.rowIndex},  is an error type")
        }
    }
}
