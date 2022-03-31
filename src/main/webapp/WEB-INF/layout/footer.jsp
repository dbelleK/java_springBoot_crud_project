<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <style>
    .footer {
    background-color: #fafafa;
    padding: 12rem 0.5rem 13rem;
    }

    body{
    line-height: 2.428571;
    }
    </style>


<footer class="footer">
    <div class="container">
        <div class="content has-text-centered">

            <div class="links">
                 <div class="col-md-6 col-lg-3">
                     <p class="section-title text-white h5 mb-4">주소<span></span></p>
                     <p><i class="fa fa-map-marker-alt me-3"></i>  서울특별시 종로구 종로12길 15 5층 (관철동 13-13)</<p>
                     <p><i class="fa fa-phone-alt me-3"></i>  010-1234-5678</p>
                     <p><i class="fa fa-envelope me-3"></i>  dbellemallcompany6@gmail.com</p>
                 </div>

                <div class="col-md-6 col-lg-3">
                    <p class="section-title text-white h5 mb-4">바로가기<span></span></p>
                        <a href="/service"><p>- SERVICE</p></a>
                        <a href="/team"><p>- TEAM</p></a>
                        <a href="/cs/faq"><p>- CS</p></a>
               </div>
           </div>
<%--            <p>--%>
<%--                <a href="https://bulma.io">--%>
<%--                    <img src="https://bulma.io/images/made-with-bulma.png" alt="Made with Bulma" width="128" height="24">--%>
<%--                </a>--%>
<%--            </p>--%>
        </div>
    </div>
</footer>

    <script>
    // Hamburger menu functionality
    document.addEventListener('DOMContentLoaded', () => {
        const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);
        if ($navbarBurgers.length > 0) {
        $navbarBurgers.forEach(el => {
        el.addEventListener('click', () => {
            const target = el.dataset.target;
            const $target = document.getElementById(target);
        el.classList.toggle('is-active');
        $target.classList.toggle('is-active');
            });
        });
        }
    });
    </script>


</body>

</html>