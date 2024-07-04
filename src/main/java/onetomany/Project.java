package onetomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<Task> tasks = new HashSet<>();

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setProject(this);
    }
}
