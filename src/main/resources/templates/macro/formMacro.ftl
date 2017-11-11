<#import "/spring.ftl" as spring />

<#macro displayFiled field attributes="" messageKey=field  >
<div class="row">
    <label class="col-sm-2"">
    <@spring.message messageKey/>
    </label>
    <div class="col-sm-10">
    ${field}
    </div>
</div>
</#macro>

<#------------------------------------------------------------------------------------------------------------------------>




<#------------------------------------------------------------------------------------------------------------------------>


<#macro inputText path attributes="" type="" title="" name="" id="" >

    <@spring.bind path/>

    <#assign error>
        <#if spring.status.errorMessages?has_content>error</#if>
    </#assign>

        <div ${error} >
            <#nested/>
                <input type="${type}" class="form-control" name="${spring.status.expression}"
                       value="${spring.stringStatusValue}" ${attributes} title="${title}" id="${id}">
                <#if error?has_content>
                    <span class="help-inline">
                        <@spring.showErrors path,"error" />
                    </span>
                </#if>
        </div>

    <span class="help-inline">
           <div id="messages"></div>
    </span>


<#--<div style="text-align: center">-->
</#macro>



<#------------------------------------------------------------------------------------------------------------------------>

<#macro label messageKey id="" >

    <label class="control-label">
        <@spring.message messageKey/>
    </label>

    <div>
        <#nested/>
    <div>
</#macro>



<#--

<#macro inputText path attributes="" type="text" title="" name="" id="" >

    <@spring.bind path/>

    <#assign error>
        <#if spring.status.errorMessages?has_content>error</#if>
    </#assign>

    <div class="form-group ${error}">
        <#nested/>
        <div class="col-md-3">
            <input type="${type}" class="form-control" name="${spring.status.expression}"
                   value="${spring.stringStatusValue}" ${attributes} title="${title}" id="${id}">
            <#if error?has_content>
                <span class="help-inline">
                    <@spring.showErrors path,"error" />
                    </span>
            </#if>
        </div>
    </div>

    <span class="help-inline">
           <div id="messages"></div>
    </span>

</#macro>


-->
