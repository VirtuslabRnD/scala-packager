package packager.mac

import packager.NativePackager
import packager.PackagerUtils.{osCopy, osWrite}
import packager.config.MacOSSettings

trait MacOSNativePackager extends NativePackager {

  protected val macOSAppPath: os.Path = basePath / s"$packageName.app"
  protected val contentPath: os.Path = macOSAppPath / "Contents"
  protected val macOsPath: os.Path = contentPath / "MacOS"
  protected val infoPlist: MacOSInfoPlist =
    MacOSInfoPlist(packageName, nativePackageSettings.identifier)

  override def nativePackageSettings: MacOSSettings =
    buildOptions.macOS.getOrElse(
      sys.error("Required settings for macOS package")
    )

  def createAppDirectory(): Unit = {
    os.makeDir.all(macOsPath)

    val appPath = macOsPath / packageName
    osCopy(sourceAppPath, appPath)
  }

  protected def createInfoPlist(): Unit = {
    val infoPlistPath = contentPath / "Info.plist"

    osWrite(infoPlistPath, infoPlist.generateContent)
  }
}
