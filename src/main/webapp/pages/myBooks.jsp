<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<body>

<h1 style="text-align:center;">My Books</h1>

<table style="margin-left: auto; margin-right: auto">
    <tr>
        <th>Author</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Price</th>
        <th>Publish Date</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${user.getBooksBorrowed()}" var="book">
        <tr>
            <th>${book.getAuthor()}</th>
            <th>${book.getTitle()}</th>
            <th>${book.getGenre()}</th>
            <th>${book.getPrice()}</th>
            <th>${book.getPublish_date()}</th>
            <th>${book.getDescription()}</th>
            <th><button><a style="text-decoration:none" href="/myBooks?bookID=${book.getId()}&userID=${user.getUserID()}&return=true">Return</a></button></th>
        </tr>
    </c:forEach>
</table>

<div style="text-align:center; margin-top:20px">
    <button><a style="text-decoration:none" href="/catalog?user=${user.getUserID()}">Borrow books</a></button>
</div>


</body>