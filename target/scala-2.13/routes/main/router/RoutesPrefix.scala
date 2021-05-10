// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Qi_Workspace/IdeaProjects/PlayScalaRestApi/conf/routes
// @DATE:Tue Mar 23 11:38:59 CST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
