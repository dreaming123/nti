package com.jcz.controller.other;


import com.jcz.dao.MUserMapper;
import com.jcz.entity.Item;
import com.jcz.entity.MUser;
import com.jcz.model.Rest_M;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/other")

@CrossOrigin
public class ExcelProccess {
    @Autowired
    MUserMapper dao;


    @Transactional
    @RequestMapping("/addExcelForItem")
    @ResponseBody
    public Object addExcelForItem(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("开始");
        InputStream inputStream = file.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        //HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        //HSSFSheet sheet = workbook.getSheetAt("Sheet1");


        Rest_M rest = new Rest_M<String>();
        List data = new ArrayList<String>();
        MUser user;
        HSSFSheet sheet = workbook.getSheet("Sheet1");

        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {

            HSSFRow row = sheet.getRow(i);
            String id = row.getCell(0).getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
            String age = row.getCell(2).getStringCellValue();
            user = new MUser(id, name, age, null);
            if (dao.insert(user) == 1) {
                data.add(name + "导入成功");
            }

            System.out.println(id + "-" + name + "-" + age);
        }
        rest.setData(data);
        return rest;
    }

    @Transactional
    @ResponseBody
    @RequestMapping("shipper")
    public Object readShipper() throws Exception {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/shipper.xls";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        HSSFSheet sheet = workbook.getSheet("Sheet1");

        int lastRowIndex = sheet.getLastRowNum();

        System.out.println(lastRowIndex);

        for (int i = 0; i <= lastRowIndex; i++) {
            HSSFRow row = sheet.getRow(i);


            System.out.println(row.getCell(0).getStringCellValue());
            String str = row.getCell(0).getStringCellValue().trim();
            String[] strArr = str.split("、");

            for (int j = 0; j < strArr.length; j++) {
                String name = strArr[j];
                if (!name.equals("") && dao.selectShipper(name) == 0) {
                    int a = dao.insertShipper(name);
                    if (a == 1) {
                        System.out.println("插入成功");
                    }
                } else {
                    System.out.println("已经存在这个材料名称");
                }
            }
            if (row == null) {
                continue;
            }


           /*   short lastCellNum = row.getLastCellNum();
              for (int j = 0; j < lastCellNum; j++) {
                  String cellValue = row.getCell(j).getStringCellValue();
                  System.out.println(cellValue);
              } */
        }


        bufferedInputStream.close();

        return "123";
    }


    @Transactional
    @RequestMapping("/addUser")


    @ResponseBody
    public Object addUser(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        //HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        //HSSFSheet sheet = workbook.getSheetAt("Sheet1");


        Rest_M rest = new Rest_M<String>();
        List data = new ArrayList<String>();
        MUser user;
        HSSFSheet sheet = workbook.getSheet("sheet1");

        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {

            HSSFRow row = sheet.getRow(i);
            String id = row.getCell(0).getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
            String age = row.getCell(2).getStringCellValue();
            user = new MUser(id, name, age, null);
            if (dao.insert(user) == 1) {
                data.add(name + "导入成功");
            }

            System.out.println(id + "-" + name + "-" + age);
        }
        rest.setData(data);
        return rest;
    }


    @Transactional
    @RequestMapping("/addItems")
    //@ResponseBody
    public ModelAndView addItems(@RequestParam("file") MultipartFile file) throws IOException {


        InputStream inputStream = file.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        //HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        //HSSFSheet sheet = workbook.getSheetAt("Sheet1");
        ModelAndView mv=new ModelAndView();

        Rest_M rest = new Rest_M<String>();
        List data = new ArrayList<String>();
        List<Item> errItems = new ArrayList<Item>();

        try {


            HSSFSheet sheet = workbook.getSheet("sheet1");
            Item item;
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 1; i <= lastRowNum; i++) {
                try {


                    HSSFRow row = sheet.getRow(i);
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    String code = row.getCell(0).getStringCellValue().trim();
                    String name = row.getCell(1).getStringCellValue().trim();
                    String unit = row.getCell(2).getStringCellValue().trim();
                    String cadno = row.getCell(3).getStringCellValue().trim();//图件号
                    String samecode = row.getCell(4).getStringCellValue().trim();//规格
                    String exteriorcode = row.getCell(5).getStringCellValue().trim();//型号

                      String description =  row.getCell(6).getStringCellValue(); //描述
                    String  price =  row.getCell(7).getStringCellValue();  //单价
                    unit = dao.getUnitByName(unit);

                    item = new Item(code, exteriorcode, name, description, unit, samecode, cadno,price);

                    int tag = dao.checkItem(item);
                    if (tag > 0) {
                        errItems.add(item);
                        throw new IOException(name +" 导入失败,物料编码"+code+"已经存在 " );


                    } else if (dao.insertItems(item) == 1) {
                        //  data.add(name+"导入成功");
                        // row.getCell(7).setCellValue("成功");
                    } else {
                        errItems.add(item);
                        throw new IOException(name  +"  导入失败,请联系系统管理员" );
                    }
                } catch (Exception e) {

                    data.add(e.getMessage());
                }

            }
            rest.setData(errItems);
            rest.setSuccess(true);//成功
            rest.setMsg("成功导入");

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//关键
            data.clear();
            data.add("系统出错，所有数据导入失败,请联系管理员！");
            rest.setData(data);
            rest.setSuccess(false);
            rest.setMsg("全部数据导入失败，请联系系统管理员");
        } finally {
            mv.addObject("res",rest);
            mv.setViewName("addItems");
            return mv;
    }        }

}
