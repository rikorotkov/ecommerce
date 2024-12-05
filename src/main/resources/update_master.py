import os

MASTER_FILE = "db.changelog-master.yaml"
CHANGELOG_DIR = "db/changelog"

def update_master():
    with open(MASTER_FILE, "w") as master:
        master.write("databaseChangeLog:\n")
        for file in sorted(os.listdir(CHANGELOG_DIR)):
            if file.endswith(".yaml"):
                master.write(f"  - include:\n      file: db/changelog/{file}\n")

if __name__ == "__main__":
    update_master()
    print(f"Updated {MASTER_FILE} with changelog files.")
