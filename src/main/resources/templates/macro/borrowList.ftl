<#import "/spring.ftl" as spring />
<#macro borrowList borrows>
<div id="tabs">
    <table id="borrow" class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>Id</th>
            <th>Borrower First Name</th>
            <th>Borrower Last Name</th>
            <th>Book Title</th>
        </tr>
        </thead>
        <tbody id="bookList">
            <#list borrows as borrow>
            <tr>
                <td><input class="selectedBorrow" type="radio" value="${borrow.id}" name="id"/></td>
                <td>${borrow.id}</td>
                <td>${borrow.borrowerDto.firstName}</td>
                <td>${borrow.borrowerDto.lastName}</td>
<#--                <td>${borrow.bookDto.bookTitle}</td>-->
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#macro>


