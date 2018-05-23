
import edu.cornell.cac.sbh.repeater.server.RepeatAll
import org.scalatra.LifeCycle
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context mount (new RepeatAll, "/*")
  }
}