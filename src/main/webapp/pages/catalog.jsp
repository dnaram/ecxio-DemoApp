<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<body>

<h1 style="text-align:center;">Catalog</h1>

<table style="margin-left: auto; margin-right: auto">
    <tr>
        <th>Author</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Price</th>
        <th>Publish Date</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <th>${book.getAuthor()}</th>
            <th>${book.getTitle()}</th>
            <th>${book.getGenre()}</th>
            <th>${book.getPrice()}</th>
            <th>${book.getPublish_date()}</th>
            <th>${book.getDescription()}</th>
            <c:choose>
                <c:when test="${book.getOwner() != null}">
                     <th>Borrowed by ${book.getOwner().getFirstName()} ${book.getOwner().getLastName()}<th>
                </c:when>
                <c:otherwise>
                      <th>Available<th>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${book.getUserID() != null}">
                    <th><button disabled>Borrow</button><th><br/>
                </c:when>
                <c:otherwise>
                    <th><button><a style="text-decoration:none" href="/myBooks?bookID=${book.getId()}&userID=${userID}&return=false">Borrow</a></button><th><br/>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>

<div style="text-align:center; margin-top:20px">
    <button onclick="goBack()">Go back</button><br/>

    <form action="/catalog" method="POST">
        <label for="filter">Filter by:</label>
        <select id="filter" name="filterBy">
            <option value="author">Author</option>
            <option value="title">Title</option>
            <option value="description">Description</option>
            <option value="published_date">Published Date</option>
        </select>
        <label id="search"><b>Search:</b></label>
        <input type="text" placeholder="Search text" name="searchText">

        <label id="available"><b>Only Available:</b></label>
          <input type="radio" id="yes" name="available" value="yes" checked>
          <label for="yes">Yes</label>
          <input type="radio" id="no" name="available" value="no">
          <label for="no">No</label><br/>

        <button onclick="check()" type="submit">Filter</button><br/>
    <from/>

</div>

</body>

<script>
function goBack() {
  window.history.back();
}

</script>