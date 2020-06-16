public class TestProjectModel {
  String name;
  String prefix;
  String projectDescription;
  Boolean isPublic;

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
}
