# 📥 Maven Download & Installation Guide

## 🚀 Quick Download (2 Minutes)

### Option 1: Direct Download (Recommended)

1. **Visit Apache Maven Website**
   - Go to: https://maven.apache.org/download.cgi

2. **Download Latest Version**
   - Look for: **apache-maven-3.9.6-bin.zip** (or latest version)
   - Click the link to download

3. **Extract the Archive**
   ```powershell
   # Navigate to Downloads folder
   cd $env:USERPROFILE\Downloads
   
   # Extract (replace 3.9.6 with your version)
   Expand-Archive apache-maven-3.9.6-bin.zip -DestinationPath "C:\Program Files\Maven"
   ```

4. **Verify Installation**
   ```powershell
   # Test Maven
   "C:\Program Files\Maven\apache-maven-3.9.6\bin\mvn" --version
   ```

---

## ⚙️ Setup Environment Variables (Windows)

### Method 1: PowerShell (Quick - Current Session Only)

```powershell
# Add to current session
$env:MAVEN_HOME = "C:\Program Files\Maven\apache-maven-3.9.6"
$env:Path += ";$env:MAVEN_HOME\bin"

# Verify
mvn --version
```

### Method 2: Permanent Setup (Recommended)

1. **Open Environment Variables**
   - Press `Windows Key + X`
   - Select "System"
   - Click "Advanced system settings"
   - Click "Environment Variables" button

2. **Add MAVEN_HOME Variable**
   - Click "New" under "System variables"
   - Variable name: `MAVEN_HOME`
   - Variable value: `C:\Program Files\Maven\apache-maven-3.9.6`
   - Click OK

3. **Update PATH Variable**
   - Find "Path" in "System variables" list
   - Click "Edit"
   - Click "New"
   - Add: `%MAVEN_HOME%\bin`
   - Click OK, OK, OK

4. **Restart PowerShell**
   ```powershell
   # Close all PowerShell windows
   # Open new PowerShell window
   mvn --version
   ```

---

## 📋 Step-by-Step Installation

### Step 1: Download Maven

**Windows (Direct Download)**
```
https://maven.apache.org/download.cgi
→ Click apache-maven-3.9.6-bin.zip
→ Save to C:\Users\YourUsername\Downloads\
```

**Or via PowerShell**
```powershell
$url = "https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
$output = "$env:USERPROFILE\Downloads\apache-maven-3.9.6-bin.zip"
Invoke-WebRequest -Uri $url -OutFile $output
```

### Step 2: Extract Archive

```powershell
# Navigate to Downloads
cd $env:USERPROFILE\Downloads

# Extract to Program Files
Expand-Archive apache-maven-3.9.6-bin.zip -DestinationPath "C:\Program Files\Maven"

# Verify extraction
ls "C:\Program Files\Maven\apache-maven-3.9.6\bin"
```

You should see: `mvn` and `mvn.cmd`

### Step 3: Set Environment Variables

**Permanent Setup (Windows GUI)**

1. Right-click "This PC" → Properties
2. Advanced system settings
3. Environment Variables
4. New System Variable:
   - Name: `MAVEN_HOME`
   - Value: `C:\Program Files\Maven\apache-maven-3.9.6`
5. Edit PATH variable, add: `%MAVEN_HOME%\bin`
6. Click OK all dialogs
7. **Restart PowerShell**

### Step 4: Verify Installation

```powershell
mvn --version
```

Expected output:
```
Apache Maven 3.9.6 (...)
Maven home: C:\Program Files\Maven\apache-maven-3.9.6
```

---

## 🐛 Troubleshooting

### Issue: "mvn is not recognized"

**Solution 1: Add to PATH temporarily**
```powershell
$env:Path += ";C:\Program Files\Maven\apache-maven-3.9.6\bin"
mvn --version
```

**Solution 2: Set environment variables permanently**
- Follow "Step 3" above with Windows GUI
- **Must restart PowerShell after setting**

**Solution 3: Run with full path**
```powershell
C:\Program Files\Maven\apache-maven-3.9.6\bin\mvn --version
```

### Issue: Java not found

```powershell
# Check Java installation
java --version

# If not found, download from:
# https://www.oracle.com/java/technologies/downloads/
```

Maven requires Java 8 or higher.

### Issue: Download is slow

Try alternative download from Maven mirrors:
```
https://maven.aliyun.com/repository/public
https://repo.maven.apache.org/maven2
```

---

## 💻 Alternative: Chocolatey Installation (Windows Package Manager)

If you have **Chocolatey** installed:

```powershell
# Install Maven via Chocolatey
choco install maven

# Verify
mvn --version
```

If you don't have Chocolatey:
```powershell
# Install Chocolatey first
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

# Then install Maven
choco install maven
```

---

## 🔗 Important Paths

| Item | Path |
|------|------|
| **Maven Home** | `C:\Program Files\Maven\apache-maven-3.9.6` |
| **Maven Executable** | `C:\Program Files\Maven\apache-maven-3.9.6\bin\mvn.cmd` |
| **Maven Repository** | `C:\Users\YourUsername\.m2\repository` |
| **Settings File** | `C:\Program Files\Maven\apache-maven-3.9.6\conf\settings.xml` |

---

## ✅ Complete Verification Checklist

After installation, verify:

```powershell
# 1. Maven installed
mvn --version

# 2. Java installed
java --version

# 3. MAVEN_HOME set
$env:MAVEN_HOME

# 4. Can run from any location
cd C:\
mvn --version

# 5. Navigate to project
cd "c:\Users\2458034\OneDrive - Cognizant\Desktop\SELENIUM_MINI_PROJECT\Project_Linear_Code"

# 6. Build project
mvn clean install

# 7. Run test
mvn exec:java -Dexec.mainClass="org.example.tests.CarInsuranceTest"
```

---

## 📦 Required Versions

- **Maven:** 3.6.0 or higher
- **Java:** 11 or higher
- **Windows:** Any version (XP/Vista/7/8/10/11)

---

## 🎯 Next Steps

After Maven is installed and verified:

```powershell
# 1. Navigate to project
cd "c:\Users\2458034\OneDrive - Cognizant\Desktop\SELENIUM_MINI_PROJECT\Project_Linear_Code"

# 2. Build project
mvn clean install

# 3. Run your tests
mvn exec:java -Dexec.mainClass="org.example.tests.CarInsuranceTest"
mvn exec:java -Dexec.mainClass="org.example.tests.BikeInsuranceTest"
mvn exec:java -Dexec.mainClass="org.example.tests.TravelInsuranceTest"
```

---

## 📚 Additional Resources

- **Apache Maven Official Site:** https://maven.apache.org
- **Maven Download Page:** https://maven.apache.org/download.cgi
- **Maven Documentation:** https://maven.apache.org/guides/
- **Maven Getting Started:** https://maven.apache.org/guides/getting-started/

---

**If you need help after installation, run this to get diagnostic info:**

```powershell
# Diagnostic script
Write-Host "=== Maven Diagnostic ===" -ForegroundColor Green
Write-Host "Maven Home: $env:MAVEN_HOME"
Write-Host "Java Version:" (java --version 2>&1 | Select-Object -First 1)
Write-Host "Maven Version:" (mvn --version 2>&1 | Select-Object -First 1)
Write-Host "PATH includes Maven: $($env:Path -match 'maven')"
```

Good luck! 🚀
