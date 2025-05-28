@import com.iluk.git.mainProj.data.Entitys.Companie
@import java.util.List
@param List<Companie> comps

@template.layout.main(
content = @`
    <div class="container">
        <h2>Companies List</h2>
        <a href="/companie/add" class="btn-add">Add New Company</a>
        <table class="data-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Activity Type</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            @for(Companie company : comps)
                <tr>
                    <td>${company.getCompany_id()}</td>
                    <td>${company.getName()}</td>
                    <td>${company.getActivityType()}</td>
                    <td>${company.getAddress()}</td>
                    <td>${company.getPhone()}</td>
                    <td>
                        <a href="/companie/edit?id=${company.getCompany_id()}" class="btn-edit">Edit</a>
                        <a href="/companie/delete?id=${company.getCompany_id()}" class="btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
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