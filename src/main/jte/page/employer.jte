@import com.iluk.git.mainProj.data.Employer
@import java.util.List
@param List<Employer> empls
@template.layout.main(content = @`
    <ul>
        @for(Employer empl: empls)
            <li>
                <div class="employee">

                    <p>${empl.getLastName()}</p>
                    <p>${empl.getFirstName()}</p>
                    <p>${empl.getMiddleName()}</p>
                    <p>${empl.getQualification()}</p>
                    <p>${empl.getActivityType()}</p>
                    <p>${empl.getOtherInfo()}</p>
                    <p>${empl.getExpectedSalary()}</p>
                </div>
            </li>
        @endfor
    </ul>

`)
