@import com.iluk.git.mainProj.data.Entitys.Agreement
@import com.iluk.git.mainProj.data.Entitys.Employer
@import com.iluk.git.mainProj.data.Entitys.Companie
@import java.util.List
@param Agreement agreement
@param List<Employer> empls
@param List<Companie> comps

@template.layout.main(
content = @`
    <div class="agreement-form-container">
        <h2>Edit Agreement</h2>
        <form action="/agreement/edit" method="post" class="agreement-form">
            <input type="hidden" name="id" value="${agreement.getAgreement_id()}">

            <div class="form-group">
                <label for="employerId">Select Employer:</label>
                <select id="employerId" name="employerId" class="form-control" required>
                    @for(Employer empl : empls)
                        <option value="${empl.getEmployer_id()}" ${empl.getEmployer_id() == agreement.getEmpl().getEmployer_id() ? "selected" : ""}>
                            ${empl.getLastName()} ${empl.getFirstName()} (${empl.getQualification()})
                        </option>
                    @endfor
                </select>
            </div>

            <div class="form-group">
                <label for="companyId">Select Company:</label>
                <select id="companyId" name="companyId" class="form-control" required>
                    @for(Companie comp : comps)
                        <option value="${comp.getCompany_id()}" ${comp.getCompany_id() == agreement.getCompany().getCompany_id() ? "selected" : ""}>
                            ${comp.getName()} (${comp.getActivityType()})
                        </option>
                    @endfor
                </select>
            </div>

            <div class="form-group">
                <label for="pos">Position:</label>
                <input type="text" id="pos" name="pos" value="${agreement.getPos()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="commission">Commission:</label>
                <input type="number" step="0.01" id="commission" name="commission" value="${agreement.getCommission()}" required class="form-control">
            </div>

            <button type="submit" class="btn-submit">Update Agreement</button>
        </form>
    </div>
`,
headContent = @`
    <style>
        .agreement-form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .agreement-form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-control {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .btn-submit {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        .btn-submit:hover {
            background-color: #45a049;
        }
    </style>
`
)