<%@ page import="com.example.web1.Gorev" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.1/mdb.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {

      $('#gorevler').DataTable({
        responsive: true,
        order:[0,"desc"],
        language: {
          url: 'https://cdn.datatables.net/plug-ins/1.13.4/i18n/tr.json',
        },
      });
    } );
  </script>

  <title>Görevler</title>
</head>
<body data-bs-theme="dark" style="background-color: #2b2f32">
<style>
  .dataTables_wrapper .dataTables_filter input {
    background-color: #2b2f32;
  }
  .dataTables_wrapper .dataTables_length select {
    background-color: #2b2f32;
  }
</style>
<div class="container">
    <div class="row"  style="display:flex;align-items: center;justify-content: center;margin-top:50px">
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">

                                Toplam Görev

                            </div>
                            <div class="h5 mb-0 font-weight-bold " style="color:#000" ><%= request.getAttribute("toplamgorev") %></div>

                        </div>
                        <div class="col-auto">
                            <i class="fa-solid fa-clipboard-list  fa-2x" style="color:#000"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1" style="color: #e40e0e !important;" >
                                Acil Görevler

                            </div>
                            <div class="h5 mb-0 font-weight-bold " style="color:#000" ><%= request.getAttribute("aciliyetliGorev") %></div>

                            <a href="gorevler?islem=listele&filtre=acil" style="color:#000; font-size:12px">Detaylı İncele ></a>
                        </div>
                        <div class="col-auto">
                            <i class="fa-solid fa-circle-exclamation  fa-2x" style="color:#000"></i>


                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                Bekleyen Görevler
                            </div>
                            <div class="h5 mb-0 font-weight-bold " style="color:#000" ><%= request.getAttribute("toplamBekleyenGorev") %></div>
                            <a href="gorevler?islem=listele&filtre=bekleyen" style="color:#000; font-size:12px">Detaylı İncele ></a>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-clock fa-2x " style="color:#000" ></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                Tamamlanan Görevler
                            </div>
                            <div class="h5 mb-0 font-weight-bold " style="color:#000" ><%= request.getAttribute("toplamtamamlanangorev") %></div>
                            <a href="gorevler?islem=listele&filtre=tamamlanan" style="color:#000; font-size:12px">Detaylı İncele ></a>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-circle-check fa-2x " style="color:#000" ></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 mb-4">


            <%

                String durum = request.getAttribute("durum").toString();
                if (durum.equals("OK")) {
            %>
            <div class="alert alert-success" role="alert" data-mdb-color="success">
                İşlem Başarılı!
            </div>
            <%
            } else if (durum.equals("ERROR")) {
            %>
            <div class="alert alert-danger" role="alert" data-mdb-color="danger">
                İşlem yapılırken bir hata ile karşılaşıldı!
            </div>
            <%
            } else {
            %>

            <%
                }
            %>
        </div>
    </div>
  <div class="row" style="display:flex;align-items: center;justify-content: center;margin-top:50px">
      <%  String kontrol = request.getAttribute("kontrol").toString();
          if (!kontrol.equals("OK")){ %>

    <div class="col-md-12 mb-4" >
      <div class="card" data-bs-theme="light">
        <div class="card-body">
          <form action="gorevler" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-outline mb-4">
              <input type="text" name="gorevadi" id="gorevAdi" class="form-control" />
              <label class="form-label" for="gorevAdi">Görev Adı</label>
            </div>
            <div class="form-outline mb-4">
              <textarea class="form-control" name="gorevaciklama" id="gorevaciklama" rows="4"></textarea>
              <label class="form-label" for="gorevaciklama">Görev Açıklaması</label>
            </div>


            <select class="form-outline mb-4 form-select form-select-sm" name="gorevoncelik" aria-label=".form-select-sm example">
              <option value="" disabled selected>Görev Önceliği Seçin</option>
              <option value="dusuk">Düşük</option>
              <option value="orta">Orta</option>
              <option value="yuksek">Yüksek</option>
            </select>
            <select class="mb-4 form-select form-select-sm" name="gorevdurum" aria-label=".form-select-sm example">
              <option value="bekliyor" >Bekliyor</option>
              <option value="baslandi" >Başlandı</option>
              <option value="ertelendi" >Ertelendi</option>
              <option value="tamamlandi">Tamamlandı</option>
            </select>
              <button type="submit" class="btn btn-primary">Gönder</button>
            </form>
        </div>
      </div>




    </div>
      <% }else{ %>
      <div class="col-md-12 mb-4">
      <div class="alert alert-info" role="alert">
          <%
              String degisken = request.getAttribute("filtre").toString();
              String filtre = degisken.substring(0, 1).toUpperCase() + degisken.substring(1);
              %>
            <%= filtre %>  Görevleri İnceliyorsunuz.  <a  href="gorevler">Geri Dön</a>
      </div>
      </div>
      <% }
         %>

    <div class="col-md-12 mb-4" >
      <div class="card" data-bs-theme="light">
        <div class="card-body">
          <table class="table" id="gorevler"  style="width:100%">
            <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Görev Adı</th>
              <th scope="col">Görev Açıklaması</th>
              <th scope="col">Görev Öncelik</th>
              <th scope="col">Görev Durumu</th>
              <th scope="col">İşlemler</th>
            </tr>
            </thead>
            <tbody>
            <%
              List<Gorev> Gorevler = (List<Gorev>) request.getAttribute("gorevler");

             if(Gorevler.isEmpty()){
            %>
            <tr>

              <td colspan="6">GOREV BULUNAMADI</td>
            </tr>
           <%  }else{


           %>


            <c:forEach var="gorev" items="${gorevler}">
              <tr>

                <td> ${gorev.id}</td>
                <td>${gorev.gorevadi}</td>
                <td>${gorev.gorevaciklama}</td>
                <td>
                  <c:choose>
                    <c:when test="${gorev.gorevoncelik eq 'dusuk'}">
                      <span class="badge badge-info">Düşük</span>
                    </c:when>
                    <c:when test="${gorev.gorevoncelik eq 'orta'}">
                      <span class="badge badge-warning">Orta</span>
                    </c:when>
                    <c:when test="${gorev.gorevoncelik eq 'yuksek'}">
                      <span class="badge badge-danger">Yüksek</span>
                    </c:when>

                  </c:choose>


                </td>
                <td>
                  <c:choose>
                    <c:when test="${gorev.gorevdurum eq 'bekliyor'}">
                      Bekliyor
                    </c:when>
                    <c:when test="${gorev.gorevdurum eq 'baslandi'}">
                      Başlandı
                    </c:when>
                    <c:when test="${gorev.gorevdurum eq 'ertelendi'}">
                      Ertelendi
                    </c:when>
                    <c:when test="${gorev.gorevdurum eq 'tamamlandi'}">
                      Tamamlandı
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                  </c:choose>

                </td>
                <c:url var="silBaglanti" value="/gorevler">
                  <c:param name="islem" value="Sil" />
                  <c:param name="gorevId" value="${gorev.id}" />
                </c:url>
                <td>
                  <a href="" type="button" data-bs-toggle="modal" data-bs-target="#gorevDuzenle${gorev.id}" class="btn btn-primary btn-floating">
                    <i class="fas fa-edit"></i>
                  </a>
                  <a href="${silBaglanti}" type="button" class="btn btn-primary btn-floating">
                    <i class="fas fa-trash"></i>
                  </a>



                </td>


              </tr>

            </c:forEach>


            <% } %>

            </tbody>
          </table>
            <div style="
    text-align: center;
"><span style="
    /* width: 100%; */
    color: #2b2f32;
    font-size: 12px;
">Kodlama &amp; Tasarım: Beyza DOĞAN ve Fetih AKGÜN tarafından yapılmıştır.</span></div>
        </div>
      </div>




    </div>

  </div>
</div>
<!-- Button trigger modal -->


<c:forEach var="gorev" items="${gorevler}">
  <div class="modal fade" id="gorevDuzenle${gorev.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">${gorev.gorevadi} Düzenle</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form action="gorevler" method="post">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="id" value="${gorev.id}">
            <div class="mb-4">
              <label for="gorevAdi" class="form-label">Görev Adı</label>
              <input type="text" name="gorevadi" id="gorevAdi" value="${gorev.gorevadi}" class="form-control" />
            </div>
            <div class="mb-4">
              <label for="gorevaciklama" class="form-label">Görev Açıklaması</label>
              <textarea class="form-control" name="gorevaciklama" id="gorevaciklama" rows="4">${gorev.gorevaciklama.trim()}</textarea>
            </div>
            <select class="mb-4 form-select form-select-sm" name="gorevoncelik" aria-label=".form-select-sm example">
              <option value="dusuk" ${gorev.gorevoncelik == 'dusuk' ? 'selected' : ''}>Düşük</option>
              <option value="orta" ${gorev.gorevoncelik == 'orta' ? 'selected' : ''}>Orta</option>
              <option value="yuksek" ${gorev.gorevoncelik == 'yuksek' ? 'selected' : ''}>Yüksek</option>
            </select>
            <select class="mb-4 form-select form-select-sm" name="gorevdurum" aria-label=".form-select-sm example">
              <option value="bekliyor" ${gorev.gorevdurum == 'bekliyor' ? 'selected' : ''}>Bekliyor</option>
              <option value="baslandi" ${gorev.gorevdurum == 'baslandi' ? 'selected' : ''}>Başlandı</option>
              <option value="ertelendi" ${gorev.gorevdurum == 'ertelendi' ? 'selected' : ''}>Ertelendi</option>
              <option value="tamamlandi" ${gorev.gorevdurum == 'tamamlandi' ? 'selected' : ''}>Tamamlandı</option>
            </select>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Kapat</button>
            <button type="submit" class="btn btn-primary">Gönder</button>
          </form>


        </div>
        <div class="modal-footer">

        </div>
      </div>
    </div>
  </div>



</c:forEach>

<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.1/mdb.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>
