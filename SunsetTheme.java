import com.formdev.flatlaf.FlatLightLaf;

public class SunsetTheme
	extends FlatLightLaf
{
	public static final String NAME = "SunsetTheme";

	public static boolean setup() {
		return setup( new SunsetTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, SunsetTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
