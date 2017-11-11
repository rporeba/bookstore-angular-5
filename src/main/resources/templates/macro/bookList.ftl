<#import "/spring.ftl" as spring />
<#macro bookList books>
    <div id="tabs">
        <table id="book" class="table table-striped">
            <thead>
            <tr>
                <th></th>
                <th>ISBN</th>
                <th>Book Title</th>
                <th>Number of Page</th>
                <th>Release Date</th>
                <th>Type</th>
                <th>Author name</th>
                <th>Author surname</th>
                <th>Borrower</th>
            </tr>
            </thead>
            <tbody id="bookList">
                <#list books as book>
                <tr>
                    <td><input class="selectedBook" type="radio" value="${book.itemId}" name="itemId"/></td>
                    <td>${book.isbn}</td>
                    <td>${book.bookTitle}</td>
                    <td>${book.numberOfPage}</td>
                    <td>${book.published}</td>
                    <td>${book.typeOfBook}</td>
                    <td>${book.authorDto.firstName}</td>
                    <td>${book.authorDto.lastName}</td>
                    <td>
                        <#if (book.borrowerDto.lastName)??>
                        ${book.borrowerDto.lastName}
                        ${book.borrowerDto.firstName}
                        <#else>
                            -
                        </#if>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</#macro>


