import com.formdev.flatlaf.FlatLightLaf;

public class SunriseTheme
	extends FlatLightLaf
{
	public static final String NAME = "SunriseTheme";

	public static boolean setup() {
		return setup( new SunriseTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, SunriseTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
