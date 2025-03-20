import os
import re

def extract_classes_from_java(file_path):
    """Extrait les classes, attributs et méthodes d'un fichier Java."""
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()

    class_pattern = re.compile(r"class\s+(\w+)(?:\s+extends\s+(\w+))?")
    attribute_pattern = re.compile(r"(\w+)\s+(\w+);")
    method_pattern = re.compile(r"(\w+)\s+(\w+)\(.*?\)")

    classes = []
    for match in class_pattern.finditer(content):
        class_name = match.group(1)
        parent_class = match.group(2) if match.group(2) else None

        attributes = [f"- {a[1]} : {a[0]}" for a in attribute_pattern.findall(content)]
        methods = [f"+ {m[1]}() : {m[0]}" for m in method_pattern.findall(content)]

        classes.append({
            "name": class_name,
            "parent": parent_class,
            "attributes": attributes,
            "methods": methods
        })

    return classes

def generate_mermaid_code(directory):
    """Génère un diagramme de classes Mermaid à partir des fichiers Java."""
    all_classes = []
    
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                all_classes.extend(extract_classes_from_java(file_path))

    mermaid_code = ["classDiagram"]

    for cls in all_classes:
        mermaid_code.append(f"class {cls['name']} {{")
        for attr in cls["attributes"]:
            mermaid_code.append(f"  {attr}")
        for method in cls["methods"]:
            mermaid_code.append(f"  {method}")
        mermaid_code.append("}")

        if cls["parent"]:
            mermaid_code.append(f"{cls['parent']} <|-- {cls['name']}")

    return "\n".join(mermaid_code)

# Exécute le script sur le dossier "LesPirates"
project_directory = r"C:\Users\ETUDIANT-SRI\OneDrive\Documents\POO\workspace\LesPirates\src"
mermaid_result = generate_mermaid_code(project_directory)

# Sauvegarde dans un fichier Mermaid
with open("diagramme.mmd", "w", encoding="utf-8") as f:
    f.write(mermaid_result)

print("Diagramme Mermaid généré dans 'diagramme.mmd'")
