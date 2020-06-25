import java.util.Objects;

public class TestProjectModel {
  String name;
  String prefix;
  String projectDescription;
  Boolean isPublic;

  public TestProjectModel() {
  }

  public TestProjectModel(String name, String prefix, String projectDescription, Boolean isPublic) {
    this.name = name;
    this.prefix = prefix;
    this.projectDescription = projectDescription;
    this.isPublic = isPublic;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public void setPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  public String getName() {
    return name;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public Boolean getPublic() {
    return isPublic;
  }

  @Override
  public String toString() {
    return "TestProjectModel{" +
            "name='" + name + '\'' +
            ", prefix='" + prefix + '\'' +
            ", projectDescription='" + projectDescription + '\'' +
            ", isPublic=" + isPublic +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TestProjectModel that = (TestProjectModel) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(prefix, that.prefix) &&
            Objects.equals(projectDescription, that.projectDescription) &&
            Objects.equals(isPublic, that.isPublic);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, prefix, projectDescription, isPublic);
  }
}

