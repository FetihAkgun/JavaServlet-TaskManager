package com.example.web1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/gorevler")
public class GorevlerServlet extends HttpServlet {

    private GorevVeri GorevVeri =new GorevVeri();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String islem = request.getParameter("islem");

        if (islem != null && !islem.isEmpty()) {


            // islem parametresi var ve boş değil
            if (islem.equals("Sil")) {
                try {

                    String gorevId = request.getParameter("gorevId");
                    String Check = GorevVeri.GorevSil(Integer.parseInt(gorevId));
                    if(Check.equals("OK")){
                        response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele&d=OK");
                    }else{
                        response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele&d=ERROR");
                    }




                }catch (Exception ex) {
                    throw new RuntimeException();
                }
            }
            else if(islem.equals("listele")) {
                List<Gorev> Gorevler = GorevVeri.GorevleriGetir();
                String addcheck="false";
                String filtre = request.getParameter("filtre");
                if (filtre != null && !filtre.isEmpty()) {
                    addcheck="OK";


                    if(filtre.equals("acil")){
                        Gorevler = GorevVeri.acilGorevleriGetir();
                    }else if(filtre.equals("bekleyen")){
                        Gorevler = GorevVeri.bekleyenGorevleriGetir();
                    }else if(filtre.equals("tamamlanan")){
                        Gorevler = GorevVeri.tamamlandiGorevleriGetir();
                    }

                }else{
                    Gorevler = GorevVeri.GorevleriGetir();
                    addcheck="false";

                }




                int toplamgorev = GorevVeri.toplamGorev();
                int toplamtamamlanangorev = GorevVeri.toplamTamamlananGorev();
                int toplamBekleyenGorev = GorevVeri.toplamBekleyenGorev();
                int yuksekgorev=GorevVeri.acilgorev();
                request.setAttribute("gorevler", Gorevler);
                request.setAttribute("toplamgorev", toplamgorev);
                request.setAttribute("toplamtamamlanangorev", toplamtamamlanangorev);
                request.setAttribute("toplamBekleyenGorev", toplamBekleyenGorev);
                request.setAttribute("aciliyetliGorev", yuksekgorev);
                request.setAttribute("kontrol",addcheck);
                request.setAttribute("filtre",filtre);

                String durum = request.getParameter("d");
                if (durum != null && !durum.isEmpty()) {
                    request.setAttribute("durum", durum);
                } else {
                    request.setAttribute("durum", "none");
                }


                RequestDispatcher rs1=request.getRequestDispatcher("/anasayfa.jsp");

                try {
                    rs1.forward(request,response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(islem.equals("haha")){
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>:)</h1>");
                out.println("</body></html>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele");
        }





    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null && !action.isEmpty()) {

            if (action.equals("edit")) {
                // Görev düzenle
                String id = request.getParameter("id");
                String gorevadi = request.getParameter("gorevadi");
                String gorevaciklama = request.getParameter("gorevaciklama");
                String gorevoncelik = request.getParameter("gorevoncelik");
                String gorevdurum = request.getParameter("gorevdurum");


                Gorev gorevdata=new Gorev(Integer.parseInt(id),gorevadi,gorevaciklama,gorevoncelik,gorevdurum);


                String Check = GorevVeri.GorevDuzenle(gorevdata);
                if(Check.equals("OK")){
                    response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele&d=OK");
                }else{
                    response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele&d=ERROR");
                }


            } else if(action.equals("add")) {
                // Görev ekleme
                try {
                    String gorevadi = request.getParameter("gorevadi");
                    String gorevaciklama = request.getParameter("gorevaciklama");
                    String gorevoncelik = request.getParameter("gorevoncelik");
                    String gorevdurum = request.getParameter("gorevdurum");

                    Gorev gorevdata=new Gorev(gorevadi,gorevaciklama,gorevoncelik,gorevdurum);


                    String Check = GorevVeri.GorevEkle(gorevdata);
                    if(Check.equals("OK")){
                        response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele&d=OK");
                    }else{
                        response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele&d=ERROR"+Check);
                    }




                }catch (Exception ex) {
                    throw new RuntimeException();
                }
            }else{
                response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele");
            }
        } else {
            response.sendRedirect(request.getContextPath()+ "/gorevler?islem=listele");
        }






    }

    public void destroy() {
    }
}