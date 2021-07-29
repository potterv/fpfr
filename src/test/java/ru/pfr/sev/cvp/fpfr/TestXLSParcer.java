package ru.pfr.sev.cvp.fpfr;

import org.junit.jupiter.api.Test;
import ru.pfr.modules.xls_parser_fin_monitor.Organization;
import ru.pfr.modules.xls_parser_fin_monitor.XLSParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestXLSParcer {
    @Test
    public void getDate(){
        XLSParser xlsParser =new XLSParser();
        List<Organization>list = new ArrayList();
        list = xlsParser.parsingFileToOrgList("D:\\!!!DOCUMENTS\\ФИН. САНКЦИИ ПО СВЕРКЕ (УВЕДОМЛЕНИЯ)\\Таблица рег-новая1.xls");
//        System.out.println(list.get(7).getArrayOfIntelligence().get(0).get(0));
        System.out.println(list);
//        System.out.println(xlsParser.parsingFileToOrgList("D:\\!!!DOCUMENTS\\ФИН. САНКЦИИ ПО СВЕРКЕ (УВЕДОМЛЕНИЯ)\\Таблица рег-новая1.xls"));
//        for (Organization organization:xlsParser.parsingFileToOrgList("D:\\!!!DOCUMENTS\\ФИН. САНКЦИИ ПО СВЕРКЕ (УВЕДОМЛЕНИЯ)\\Таблица рег-новая1.xls")
//             ) {
//            System.out.println(organization.);
//        }

    }
}
