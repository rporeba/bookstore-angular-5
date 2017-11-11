<#import "/spring.ftl" as spring />
<#macro borrowerList borrowers messageKey=borrowers>		

			<div class="row">
					    <label class="col-sm-2"">
							<@spring.message messageKey/>		
	   					 </label>
				<div class="form-group">
					<div class="col-sm-2">
						<select class="form-control" id="borrowers" name="borrowerId">
							<#list borrowers as borrower>
								<option value="${borrower.borrowerId}">${borrower.lastName}</option>
							</#list>
						</select>
					</div>
				</div>
			</div>

</#macro>


