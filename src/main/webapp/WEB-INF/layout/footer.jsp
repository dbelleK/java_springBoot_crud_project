<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>




<footer class="footer">
    <div class="container">
        <div class="content has-text-centered">
            <div class="links">

                <div class="level-item">
                    <a href="#">Link One</a>
                </div>
                <div class="level-item">
                    <a href="#">Link One</a>
                </div>
                <div class="level-item">
                    <a href="#">Link One</a>
                </div>
            </div><br>
            <p>
                <a href="https://bulma.io">
                    <img src="https://bulma.io/images/made-with-bulma.png" alt="Made with Bulma" width="128" height="24">
                </a>
            </p>
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