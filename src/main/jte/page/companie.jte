@import com.iluk.git.mainProj.data.Companie
@import java.util.List
@param List<Companie> comps
@template.layout.main(content = @`
    <ul>
        @for(Companie comp: comps)
            <li>
                <div class="companie">
                    <p>${comp.getName()}</p>
                    <p>${comp.getActivityType()}</p>
                    <p>${comp.getAddress()}</p>
                    <p>${comp.getPhone()}</p>

                </div>
            </li>
        @endfor
    </ul>

`)
