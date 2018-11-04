package kmLogo.interpreter.kmLogo.extra;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.api.RootCallTarget;

import kmLogo.interpreter.kmLogo.ProcDeclaration;

public class ProcDeclarationMap {
	public static Map<ProcDeclaration, RootCallTarget> map = new HashMap<>();
}
