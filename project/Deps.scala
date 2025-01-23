import sbt._

object Deps {
  def expecty       = "com.eed3si9n.expecty"       %% "expecty"       % "0.17.0"
  def munit         = "org.scalameta"              %% "munit"         % "1.1.0"
  def osLib         = "com.lihaoyi"                %% "os-lib"        % "0.11.3"
  def caseApp       = "com.github.alexarchambault" %% "case-app"      % "2.1.0-M29"
  def thumbnailator = "net.coobird"                 % "thumbnailator" % "0.4.20"
  def image4j       = "org.jclarion"                % "image4j"       % "0.7"
  def jib           = "com.google.cloud.tools"      % "jib-core"      % "0.27.2"
  def commonsIo     = "commons-io"                  % "commons-io"    % "2.18.0"
}
