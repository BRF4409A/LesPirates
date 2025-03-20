import os
import re

def extract_class_methods_and_calls(file_path):
    """Extrait les classes, méthodes publiques et appels internes aux autres objets."""
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()

    class_match = re.search(r"class\s+(\w+)", content)
    class_name = class_match.group(1) if class_match else "UnknownClass"

    method_pattern = re.compile(r"public\s+\w+\s+(\w+)\(.*?\)\s*{")
    methods = method_pattern.findall(content)

    calls_pattern = re.compile(r"(\w+)\.(\w+)\(")  # Détecte les appels d'objets (ex: monObjet.action())
    calls = calls_pattern.findall(content)

    return class_name, methods, calls

def generate_detailed_mermaid_sequence(directory):
    """Génère un diagramme de séquence détaillé en Mermaid."""
    interactions = []
    class_methods = {}  # Stocke {classe: [méthodes]}
    calls_map = []  # Stocke les appels entre objets
    
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                class_name, methods, calls = extract_class_methods_and_calls(file_path)
                
                class_methods[class_name] = methods
                
                for caller, method in calls:
                    calls_map.append((class_name, caller, method))

    # Génération du diagramme Mermaid
    mermaid_code = ["sequenceDiagram"]

    for class_name, methods in class_methods.items():
        for method in methods:
            mermaid_code.append(f"User ->> {class_name}: {method}()")

    for caller, called_obj, method in calls_map:
        mermaid_code.append(f"{caller} ->> {called_obj}: {method}()")

    return "\n".join(mermaid_code)

# 🔹 Modifie ce chemin pour ton projet
project_directory = r"C:\Users\ETUDIANT-SRI\OneDrive\Documents\POO\workspace\LesPirates\src"

mermaid_result = generate_detailed_mermaid_sequence(project_directory)

# 🔹 Sauvegarde dans un fichier Mermaid
with open("detailed_sequence_diagram.mmd", "w", encoding="utf-8") as f:
    f.write(mermaid_result)

print("✅ Diagramme de séquence détaillé généré dans 'detailed_sequence_diagram.mmd'")
