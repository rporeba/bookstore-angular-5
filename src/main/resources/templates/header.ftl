<#import "spring.ftl" as spring />


<style>

    #logout {
        position: inherit;
        margin-bottom: 20px;
    }

</style>

<div>
    <div id="logout">
        <div class="row" style="text-align: right">
            <a href="/bookstore/logout" type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-log-out"></span> Log out
            </a>
        </div>
    </div>
    <div class="row">
        <img src="bookstore.png" class="img-responsive">
    </div>
    <h4><#if (message)??>
  			${message}
			<#else>
    </#if>
    </h4>
</div>
