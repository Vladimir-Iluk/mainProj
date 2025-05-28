@import com.iluk.git.mainProj.data.Entitys.Agreement
@import java.util.List
@param List<Agreement> agreementsList

@template.layout.main(
content = @`
    <div class="container">
        <h2>Agreements List</h2>
        <a href="/agreement/add" class="btn-add">Add New Agreement</a>
        <table class="data-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Employer</th>
                <th>Company</th>
                <th>Position</th>
                <th>Commission</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            @for(Agreement agreement : agreementsList)
                <tr>
                    <td>${agreement.getAgreement_id()}</td>
                    <td>${agreement.getEmpl().getLastName()} ${agreement.getEmpl().getFirstName()}</td>
                    <td>${agreement.getCompany().getName()}</td>
                    <td>${agreement.getPos()}</td>
                    <td>${agreement.getCommission()}</td>
                    <td>
                        <a href="/agreement/edit?id=${agreement.getAgreement_id()}" class="btn-edit">Edit</a>
                        <a href="/agreement/delete?id=${agreement.getAgreement_id()}" class="btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>
`,
headContent = @`
    <style>
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .btn-add {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            margin-bottom: 20px;
            text-decoration: none;
            border-radius: 4px;
        }

        .data-table {
            width: 100%;
            border-collapse: collapse;
        }

        .data-table th, .data-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .data-table th {
            background-color: #f2f2f2;
        }

        .data-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .btn-edit {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
        }
        .btn-delete {
            display: inline-block;
            background-color: #f44336;
            color: white;
            padding: 5px 10px;
            margin-left: 5px;
            text-decoration: none;
            border-radius: 4px;
        }

        .btn-delete:hover {
            background-color: #d32f2f;
        }
    </style>
`
)