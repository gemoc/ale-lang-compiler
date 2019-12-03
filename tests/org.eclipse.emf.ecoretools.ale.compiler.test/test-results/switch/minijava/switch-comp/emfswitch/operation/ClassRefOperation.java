package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Boolean;
import miniJava.ClassRef;
import miniJava.TypeRef;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class ClassRefOperation extends SingleTypeRefOperation {
	private final ClassRef it;

	private final SwitchImplementation emfswitch;

	public ClassRefOperation(ClassRef it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public boolean compare(TypeRef other) {
		boolean result;
		if(other instanceof ClassRef) {
			ClassRef ocr = ((ClassRef) (other));
			result = ((Boolean) (EqualService.equals((this.it.getReferencedClass()), (ocr.getReferencedClass()))));
		}
		else {
			result = ((Boolean) (false));
		}
		return result;
	}
}
