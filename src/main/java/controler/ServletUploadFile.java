package controler;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date //
 */

import Outil.CsvReader;
import metier.Ligneachat;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/ServletUploadFile")
public class ServletUploadFile extends HttpServlet {



            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");//
                InputStream in = request.getInputStream();
                int temp;
//                while ((temp = in.read()) != -1) {
//                    System.out.write(temp);
//                }
//                System.out.flush();
//                in.close();

                String pate=this.getServletContext().getRealPath("/WEB-INF/test.csv");
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                diskFileItemFactory.setSizeThreshold(1024*1024*50);
                File repository = new File(getServletContext().getRealPath(
                        "/WEB-INF/upload"));
                diskFileItemFactory.setRepository(repository);
                ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
                fileUpload.setHeaderEncoding("UTF-8");


                if(!fileUpload.isMultipartContent(request)){
                    return;
                }
                try {
                    List<FileItem> list=fileUpload.parseRequest(request);
                    for (FileItem item:list){
                        if(item.isFormField()){

                        }else{
                            String fileName=item.getName();
                            System.out.println(fileName);
                            InputStream is=item.getInputStream();
                            FileOutputStream fos=new FileOutputStream(pate);

                            byte buffer[]=new byte[1024];
                            int length=0;

                            while ((length=is.read(buffer))>0){
                                fos.write(buffer,0,length);
                            }
                            is.close();
                            fos.close();
                        }
                    }
                } catch (FileUploadException e) {
                    e.printStackTrace();
                    System.out.println("echouer");
                }
                CsvReader csvReader=new CsvReader();
                ArrayList<Ligneachat> res=csvReader.read();
                request.setAttribute("listLigne",res);
                request.getRequestDispatcher("pageFormRetour.jsp").forward(request, response);


            }

             @Override
             protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 doGet(request, response);
             }

         }
