import com.formdev.flatlaf.FlatLightLaf;

public class MoonriseTheme
	extends FlatLightLaf
{
	public static final String NAME = "MoonriseTheme";

	public static boolean setup() {
		return setup( new MoonriseTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, MoonriseTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
