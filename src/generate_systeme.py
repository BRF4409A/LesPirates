import os
import re

def extract_methods_from_java(file_path):
    """Extrait les méthodes publiques d'un fichier Java."""
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()

    class_match = re.search(r"class\s+(\w+)", content)
    class_name = class_match.group(1) if class_match else "UnknownClass"

    method_pattern = re.compile(r"public\s+\w+\s+(\w+)\(.*?\)")
    methods = method_pattern.findall(content)

    return class_name, methods

def generate_mermaid_sequence(directory):
    """Génère un diagramme de séquence Mermaid basé sur les méthodes publiques."""
    interactions = []
    
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                class_name, methods = extract_methods_from_java(file_path)
                
                for method in methods:
                    interactions.append(f"User ->> {class_name}: {method}()")
    
    mermaid_code = ["sequenceDiagram"]
    mermaid_code.extend(interactions)

    return "\n".join(mermaid_code)

# 🔹 Modifie ce chemin pour ton projet
project_directory = r"C:\Users\ETUDIANT-SRI\OneDrive\Documents\POO\workspace\LesPirates\src"

mermaid_result = generate_mermaid_sequence(project_directory)

# 🔹 Sauvegarde dans un fichier Mermaid
with open("sequence_diagram.mmd", "w", encoding="utf-8") as f:
    f.write(mermaid_result)

print("✅ Diagramme de séquence généré dans 'sequence_diagram.mmd'")
